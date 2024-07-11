# Makefile for C application

# Compiler
CC := gcc

# Directories
SRC_DIR := src
INC_DIR := include
BIN_DIR := bin
BUILD_DIR := build

# Source files (assuming all .c files in src/)
SRCS := $(wildcard $(SRC_DIR)/*.c)

# Object files (replace .c with .o)
OBJS := $(patsubst $(SRC_DIR)/%.c,$(BIN_DIR)/%.o,$(SRCS))
# Another one -> using $(subst from, to, text) by using the pattern sub.
## $(subst $(SRC_DIR)/, $(BIN_DIR)/, $(SRCS:.c=.o))

# Final executable
APP := $(BUILD_DIR)/app

INC := -I$(INC_DIR)

# Targets
all: $(APP)

$(APP): $(OBJS)
	$(CC) $(INC) -o $@ $^

$(BIN_DIR)/%.o: $(SRC_DIR)/%.c
	$(CC) $(INC) -c -o $@ $<

clean:
	rm -rf $(BIN_DIR)/* $(BUILD_DIR)/*

.PHONY: all clean
