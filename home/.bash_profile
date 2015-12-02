. /etc/bashrc

if [ -f ~/.bashrc ]; then
    . ~/.bashrc
fi

if [[ -z "$EMACS" ]]; then
    export PROMPT_COMMAND='echo -ne "\033]0;${PWD/#$HOME/~}\007"'
fi
