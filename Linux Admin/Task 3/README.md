# SectionTwo's-Answer

**1.**  ```bash
        ls /usr/bin/ > /tmp/command.list
        ```
**2.** by editing in /etc/motd file which stands for (Message of The Day) using nano editor
        ```bash
        nano /etc/motd
        ```
        this will open a window, then you can write whatever you want to display as a message when you log into a new session. Then you save using (^x -> y).

        and we can change the prompt permenantly by modifying the .bashrc file (which is a script used to configure the shell enviroment settings for the bash shell) using also nano editor:
        ```bash
        nano ~/.bashrc
        ```

        This will open the file and we change PS1 that is used to set the prompt.
        ```bash
        PS1='[\u@\h \W \d]\$ '
        ```
