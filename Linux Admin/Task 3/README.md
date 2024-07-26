# SectionTwo's-Answer

**1.**  ```bash
        ls /usr/bin/ > /tmp/command.list
        ```
        <br />
**2.** by editing in /etc/motd file which stands for (Message of The Day) using nano editor <br />
        ```bash
        nano /etc/motd
        ```
        <br />
        this will open a window, then you can write whatever you want to display as a message when you log into a new session. Then you save using (^x -> y).
        <br />
        and we can change the prompt permenantly by modifying the .bashrc file (which is a script used to configure the shell enviroment settings for the bash shell) using also nano editor:
        <br />
        ```bash
        nano ~/.bashrc
        ```
        <br />
        This will open the file and we change PS1 that is used to set the prompt.
        <br />
        ```bash
        PS1='[\u@\h \W \d]\$
        
        <br />
        then applying the changes by sourcing the .bashrc
        <br />
        ```bash
        source ~/.bashrc
        ```

**3.** The command used to count the word in a file is `wc` which stands for **Word Count** 
        <br />
        ```bash
        wc -w filename.txt
        # -w: used to as an option to count the words
        ```
        <br />
        To count the number of commands using `wc`:
        <br />
        ```bash
        wc -l /tmp/command.list
        # -l: stands for `line` which means the number of lines.
        ```
