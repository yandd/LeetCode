Redis 默认配置

redis 为了避免客户端连接数过多，有一个timeout配置，意思是如果连接的空闲时间超过了timeout的值，则关闭连接。默认配置是0，意思是没有超时限制，永远不关闭连接。生产上显然不会配置0…
这个问题的根源其实很小，但是排查过程还是花了挺多时间，主要是需要等待采集到足够的数据后用于分析。其他心得体会：
保护“案发现场”很重要，要想挖掘问题根源，必须保持环境可重现，这次出现问题的时候虽然第一时间重启了 redis 使服务恢复，但是由于没有修改任何配置，所以使得后来的监控能够发现问题根源；
使用开源软件，必须对默认配置保持警惕，相信应该有人以前听说过 redis 默认监听 0.0.0.0 来源请求的安全漏洞；
这个项目由于开始较早，当时并没有考虑使用 Redis 云数据库，自建数据库有风险，需要慎重对待，尽可能的情况下，专业的事情，交给专业的人去做。
网络通信差 : 按照 TCP 协议，客户端断开连接时，向服务器端发送 FIN 信号，但是服务端未接收到，客户端超时后放弃等待，直接断开，服务端由于通信故障，保持了 ESTABLISHED 状态，不过由于两端机器在同个内网，网络质量没有理由不行；
客户端异常 : 客户端连接之后，由于代码运行过程中产生异常，导致未正常释放或者关闭连接，sidekiq 的worker很可能就有这类问题。这个的可能性非常大，毕竟我日常写 bug ( /ω╲ )。
问题修复

找到问题根源之后，修复起来就简直太简单了。事实上，开发领域就是如此，绝大部分时间都花在了找 bug 上，而改掉bug，可能只需要一分钟不到。