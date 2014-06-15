# dotfiles

## Installing

```
cd ~
git clone --no-checkout https://github.com/codahale/dotfiles.git .dotfiles
cd ~/.dotfiles
git config core.worktree "../../"
git config status.showuntrackedfiles no
git checkout master
git checkout -f master
```

## Installing Go

```
go get github.com/nsf/gocode
go get github.com/kr/godep
go get github.com/golang/lint/golint
go get github.com/kisielk/errcheck
go get code.google.com/p/go.tools/cmd/benchcmp
go get code.google.com/p/go.tools/cmd/godex
go get code.google.com/p/go.tools/cmd/goimports
go get code.google.com/p/go.tools/cmd/oracle
go get code.google.com/p/rog-go/exp/cmd/godef
go get github.com/jteeuwen/go-bindata/go-bindata
```
