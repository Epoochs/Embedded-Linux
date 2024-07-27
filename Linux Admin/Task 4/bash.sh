#!/bin/bash

# Define variables
USER_NAME="yourName"
GROUP_NAME="FamilyName"

# Check if the user already exists
if id "$USER_NAME" &>/dev/null; then
    echo "User '$USER_NAME' already exists."
else
    echo "User '$USER_NAME' does not exist. Creating user..."
    sudo useradd "$USER_NAME"
    if [ $? -eq 0 ]; then
        echo "User '$USER_NAME' created successfully."
    else
        echo "Failed to create user '$USER_NAME'."
        exit 1
    fi
fi

# Check if the group already exists
if getent group "$GROUP_NAME" &>/dev/null; then
    echo "Group '$GROUP_NAME' already exists."
else
    echo "Group '$GROUP_NAME' does not exist. Creating group..."
    sudo groupadd "$GROUP_NAME"
    if [ $? -eq 0 ]; then
        echo "Group '$GROUP_NAME' created successfully."
    else
        echo "Failed to create group '$GROUP_NAME'."
        exit 1
    fi
fi

# Add the user to the group
sudo usermod -a -G "$GROUP_NAME" "$USER_NAME"
if [ $? -eq 0 ]; then
    echo "User '$USER_NAME' added to group '$GROUP_NAME' successfully."
else
    echo "Failed to add user '$USER_NAME' to group '$GROUP_NAME'."
    exit 1
fi

# Display information about the user
echo "Information about user '$USER_NAME':"
id "$USER_NAME"

# Display information about the group
echo "Information about group '$GROUP_NAME':"
getent group "$GROUP_NAME"

#!bin/bash