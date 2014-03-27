
wget http://packages.erlang-solutions.com/erlang-solutions_1.0_all.deb
dpkg -i erlang-solutions_1.0_all.deb
apt-get update
apt-get install -y tmux screen vim git emacs g++ gcc
apt-get install -y esl-erlang erlang-doc erlang-manpages erlang-mode make gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath libsdl1.2-dev xterm erlang qemu
wget https://github.com/rebar/rebar/wiki/rebar --output-document=/usr/bin/rebar 
chmod 755 /usr/bin/rebar
