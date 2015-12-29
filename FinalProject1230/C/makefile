SHELL = /bin/sh
RM = /bin/rm 
GCC = gcc
TARGET = order
FLAGS = -I. -I/usr/local/include -L/usr/local/lib -L/usr/lib -ljson
.PHONY : all clean
all: myorder

myorder: main.o order.o 
	$(GCC) main.o order.o  -o myorder $(FLAGS)

main: main.c order.h 
	$(GCC) -c main.c $(FLAGS)

order: order.c order.h
	$(GCC) -c order.c $(FLAGS)
clean:
	$(RM) $(TARGET) 