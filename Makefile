osx: update
	ansible-playbook -v -D -i playbooks/inventory playbooks/osx.yml

update:
	git pull
