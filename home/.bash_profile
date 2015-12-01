. /etc/bashrc

if [ -f ~/.bashrc ]; then
    . ~/.bashrc
fi

if [[ -n ${EMACS} ]]; then
    export PROMPT_COMMAND=""
else
    export PROMPT_COMMAND='echo -ne "\033]0;${PWD/#$HOME/~}\007"'
fi
