# Morse-Code
This program encodes and decodes morse code using a tree map

addSymbol(char letter, String code)
>Calls treeInsert and adds a letter and its morse code string into the encoding map

treeInsert(char letter, String code)
>Adds a letter and its morse code string into the decoding tree

start()
>Initializes codeMap with the morse code designations for the english alphabet, numbers, and select punctuation

encode(String text)
>Converts a string into morse code and returns the dot dash sequences in a string

decode(String morse)
>Converts a morse code message into text
