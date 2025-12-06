#!/usr/bin/env bash
set -euo pipefail

# Usage:
# 1) Ensure GitHub CLI is installed and authenticated: `gh auth login`
# 2) Run this script from the ToremaruUtil directory:
#    ./publish.sh [owner] [repo_name] [version]
# Example:
#    ./publish.sh officeharukaze ToremaruUtil v0.1.0

OWNER=${1:-$(git config --get user.name)}
REPO=${2:-ToremaruUtil}
VERSION=${3:-v0.1.0}

# Ensure gh is available
if ! command -v gh >/dev/null 2>&1; then
  echo "gh CLI not found. Install it: https://cli.github.com/"
  exit 1
fi

# Initialize git repo if necessary
if [ ! -d .git ]; then
  git init
  git add .
  git commit -m "Initial ToremaruUtil skeleton"
fi

# If remote origin exists, ask before overwriting
if git remote get-url origin >/dev/null 2>&1; then
  echo "Remote 'origin' already exists: $(git remote get-url origin)"
  read -p "Use existing remote? (y/n) " yn
  if [ "${yn:-n}" != "y" ]; then
    git remote remove origin
  fi
fi

# Create repo on GitHub and push (gh will prompt for visibility)
FULL_REPO="$OWNER/$REPO"
if ! gh repo view "$FULL_REPO" >/dev/null 2>&1; then
  echo "Creating repository $FULL_REPO on GitHub..."
  gh repo create "$FULL_REPO" --public --source=. --remote=origin --push
else
  echo "Repository $FULL_REPO already exists. Ensuring origin is set and pushing..."
  if ! git remote get-url origin >/dev/null 2>&1; then
    git remote add origin "git@github.com:$FULL_REPO.git"
  fi
  git push -u origin HEAD
fi

# Tag and push
if git rev-parse "$VERSION" >/dev/null 2>&1; then
  echo "Tag $VERSION already exists locally. Skipping tag creation."
else
  git tag "$VERSION"
fi

git push origin --tags

# Info
echo
echo "Repository pushed: https://github.com/$FULL_REPO"
echo "To publish artifacts, consider configuring 'maven-publish' and a CI workflow (e.g. GitHub Actions) to publish to GitHub Packages or your preferred registry."

echo "Done."
