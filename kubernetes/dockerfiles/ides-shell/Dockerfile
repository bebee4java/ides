#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# 执行下面命令进行构建
# docker build -f kubernetes/dockerfiles/ides-shell/Dockerfile -t datalinked/ides-shell:latest .

# 解除docker build日志限制，[output clipped, log limit 1MiB reached]
# 最优解：设置坏境变量 export DOCKER_BUILDKIT=0 ，然后构建。

# 另一种方法使用docker buildx 参考（不推荐）：https://docs.docker.com/engine/reference/commandline/buildx_build/
# 1. 创建更大日志输出的构建器
# docker buildx create --use --name larger_log --driver-opt env.BUILDKIT_STEP_LOG_MAX_SIZE=50000000
# 2. 构建镜像并导出结果
# docker buildx build -f kubernetes/dockerfiles/ides-shell/Dockerfile -t datalinked/ides-shell:latest -o - . > datalinked_img.tar
# 3. 导入镜像到本地仓库
# docker import datalinked_img.tar datalinked/ides-shell:latest
# end. 删除构建器实例: docker buildx rm larger_log

ARG maven_version=3.5.4

FROM maven:${maven_version}

# 必须要在FROM之后指定ARG，不然后续变量使用将不生效
ARG ides_version=1.0.0
ARG spark_big_verison=2.4

# 创建工作目录
RUN mkdir /datalinked
WORKDIR /datalinked
# 添加源码
ADD . .
# 设置maven源 加速编译
RUN cp kubernetes/dockerfiles/settings.xml /usr/share/maven/conf/
# 加入daemon
RUN cp kubernetes/dockerfiles/ides-shell/daemon /opt/

# 构建shell执行包
RUN ./bin/ides-build.sh shell
RUN tar -zxvf ides-${ides_version}-bin-spark${spark_big_verison}.tgz -C /opt
# 删除临时构建目录
RUN rm -rf /datalinked
# 删除maven构建依赖
RUN rm -rf /root/.m2/repository

# 端口声明
# spark-ui's port
EXPOSE 4040/tcp
# ides rest api's port
EXPOSE 9003/tcp

# 配置环境变量
RUN echo "\n\
IDES_HOME=/opt/ides-1.0.0-bin-spark2.4\n\
export IDES_HOME\n\
export PATH=\$PATH:\$IDES_HOME/bin" >> /etc/profile

RUN echo "\n\
source /etc/profile" >> /root/.bashrc

WORKDIR /opt/ides-${ides_version}-bin-spark${spark_big_verison}
ENTRYPOINT ["/bin/bash", "bin/ides-shell"]