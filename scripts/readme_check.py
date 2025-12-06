#!/usr/bin/env python3
"""README check:
- forbids specific terms
- detects duplicate paragraph blocks (naive)
Exit code: 0 = ok, non-zero = problems found
"""
from pathlib import Path
import re
import sys

FORBIDDEN = re.compile(r"JitPack|Jitpack|README\.md\.bak|copilot|assistant|v0\\.1\\.1|0\\.1\\.1|\b日本語\b|\bEnglish\b", re.I)

def check_forbidden(text):
    found = []
    for m in FORBIDDEN.finditer(text):
        span = m.group(0)
        # record line number
        lineno = text[:m.start()].count("\n") + 1
        found.append((lineno, span))
    return found

def find_duplicate_paragraphs(text):
    paras = []
    for p in text.split('\n\n'):
        # normalize lines inside paragraph
        t = '\n'.join(line.strip() for line in p.splitlines() if line.strip())
        if len(t.split()) > 3:
            paras.append(t)
    from collections import Counter
    c = Counter(paras)
    dups = [(cnt, p) for p, cnt in c.items() if cnt > 1]
    return dups

def main():
    p = Path('README.md')
    if not p.exists():
        print('README.md not found')
        return 2
    text = p.read_text(encoding='utf-8')
    forbidden = check_forbidden(text)
    if forbidden:
        print('Forbidden terms found in README.md:')
        for lineno, term in forbidden:
            print(f'  line {lineno}: {term}')
    dups = find_duplicate_paragraphs(text)
    if dups:
        print('\nDuplicate paragraph blocks detected:')
        for cnt, ptext in dups:
            print(f'  {cnt} occurrences: {ptext[:120].replace('\n',' ')}...')
    if forbidden or dups:
        return 1
    print('README checks passed.')
    return 0

if __name__ == '__main__':
    sys.exit(main())
