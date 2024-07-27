# Section Two

**1.** ```bash 
       sudo groupadd -g 30000 pgroup
       ```
       This command adds a new group with the group ID 30000 and the name "pgroup"
        <br />
**2.** ```bash
       sudo passwd -l username
       ```
       This command locks the password for the user "username" so that they cannot log in.
        <br />

**3.** ```bash 
        sudo usermod -s /sbin/nologin username
       ```
       <br />
        ```bash
        sudo userdel username
        ```
        This command deletes the user "username" and removes their home directory and mail spool.
        <br />

**4.** ```bash
        sudo groupdel pgroup
       ```
       This command deletes the group "pgroup" and removes it from the system.
       <br />

**5.** `adduser`:
        `Function`: Higher-level utility that provides a more interactive and user-friendly approach.
        `Syntax`: Provides interactive prompts to guide you through the process of creating a new user.
        `Default Values`: Automatically creates a home directory and sets default values.
        <br />
        ```bash
        sudo adduser newuser
        ```
        This command creates a new user named "newuser" with default values and a home directory.
        <br />
        `useradd`:
        `Function`: Lower-level utility that provides a more direct and flexible approach.
        `Syntax`: Requires specific options to customize the user creation process.
        `Default Values`: Does not automatically create a home directory or set default values.
        <br />
        ```bash
        sudo useradd -m -s /bin/bash -G pgroup newuser
        ```
        This command creates a new user named "newuser" with a home directory, sets the shell to `/bin/bash`, and adds them to the group "pgroup".
        

