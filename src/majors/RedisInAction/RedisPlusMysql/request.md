
##思考：应用网站架构的衍化过程中，应用最新的框架和工具技术固然是最优选择；但是，如果能在现有的框架的基础上提出简单可依赖的解决方案，未尝不是一种提升自我的尝试。
####解决：
1. 问题一：要求日志最好入库；但是，直接入库mysql确实扛不住，批量入库没有问题，done。【批量入库和直接入库性能差异参考文章】
2. 问题二：批量入库就需要有高并发的消息队列，决定采用redis list 仿真实现，而且方便回滚。
3. 问题三：日志量毕竟大，保存最近30条足矣，决定用php写个离线统计和清理脚本。
