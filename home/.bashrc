export EDITOR="emacs"
export CLICOLOR=1
export BROWSER=open
export PAGER=less
export JAVA_HOME="/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home"
export LC_CTYPE=en_US.UTF-8
export LESS="-XFRf -x4"
export GOPATH="$HOME/Projects/go"
export PYTHONPATH="/usr/local/lib/python2.7/site-packages:$PYTHONPATH"
export MANPATH="/usr/local/man:$MANPATH"
export PATH="~/.bin:/usr/local/sbin:/usr/local/bin:$PATH:$GOPATH/bin"
export HISTCONTROL=ignoreboth
export HISTSIZE=50000
export VAGRANT_DEFAULT_PROVIDER="vmware_fusion"

if [ -f ~/bashrc.local ]; then
    . ~/.bashrc.local
fi

shopt -s globstar # allow for **/*.blah
shopt -s dirspell # do spelling correction on directory completion-
shopt -s extglob
shopt -s histappend
shopt -s histverify
set -b

if [ -f $(brew --prefix)/etc/bash_completion ]; then
  . $(brew --prefix)/etc/bash_completion
fi

complete -C aws_completer aws

if which rbenv > /dev/null; then eval "$(rbenv init -)"; fi

function mkcd () {
    mkdir -p "$@" && cd "$@"
}

export PS1='\[\033[0;36m\]\t\[\e[0m\] \w \[\033[0;32m\]$(vcprompt -f "[%n:%b%u%m] ")\[\033[1;34m\]\$ \[\033[0m\]'
