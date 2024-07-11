; AVR assembly code is written by me for the first time ever.
.EQU SUM = 0x300 ;SRAM location 0x300 located for SUM

.ORG 00
LDI R16, 0x25
LDI R17, $34
LDI R18, 0x31
ADD R16, R17
ADD R16, R18
LDI R17, 11
ADD R16, R17
STS R16, SUM
HERE: JMP HERE