#!/bin/sh

if [ 0 = `git remote | grep "youjie" | wc -c` ];then
  git remote add youjie git@gitlab.youjie.com:jian.li02/swagger-demo.git;
fi

expect <<EOF
spawn ssh -T git@gitlab.youjie.com;
expect {
    "(yes/no)?" { send "yes\r"; exp_continue }
    "Welcome:" { interact; }
    eof
}
EOF

git checkout ${CI_BUILD_REF_NAME}

if [ "$CI_BUILD_TAG" == "" ];then
  git pull youjie ${CI_BUILD_REF_NAME}
fi

git push youjie ${CI_BUILD_REF_NAME}