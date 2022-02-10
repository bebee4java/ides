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

ARG maven_version=3.5.4
ARG ides_version=1.0.0
ARG spark_big_verison=2.4

FROM maven:${maven_version}

# 创建工作目录
RUN mkdir /datalinked
WORKDIR /datalinked
# 添加源码
ADD . .
# 设置maven源 加速编译
RUN cp kubernetes/dockerfiles/settings.xml /usr/share/maven/conf/

# 构建shell执行包
RUN ./bin/ides-build.sh shell
RUN tar -zxvf ides-${ides_version}-bin-spark${spark_big_verison}.tgz -C /opt
# 删除临时构建目录
RUN rm -rf /datalinked

WORKDIR /opt/ides-${ides_version}-bin-spark${spark_big_verison}
ENTRYPOINT ["/bin/bash", "bin/ides-shell"]