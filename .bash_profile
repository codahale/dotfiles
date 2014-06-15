. /etc/bashrc

if [ -f ~/.bashrc ]; then
    . ~/.bashrc
fi

export PROMPT_COMMAND='echo -ne "\033]0;${PWD/#$HOME/~}\007"'
