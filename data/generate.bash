#!/bin/bash

for i in {1..25}
do
	echo "wordlist_$i.txt"
	grep "^[a-z]\{$i\}$" wordlist_master.txt > wordlist_$i.txt
done
echo "Done."
