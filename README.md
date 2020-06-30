# rabbitmq_springboot_test
#from http://www.mayikt.com/course/video/4241
订单30分钟未支付，系统自动关闭有哪些实现方法?
1、任务调度(扫表)，效率低
2、基于redis过期key，监听redis过期key，表中要冗余redis产生的token
3、基于mq的延迟队列 死信队列

基于mq解决分布式事务问题
1、保证生产成功,生产消息确认confirm机制
2、保证消费成功，手动ack机制
3、确保生产第一事务成功，否则采用补单形式（补单队列，补单消费者）