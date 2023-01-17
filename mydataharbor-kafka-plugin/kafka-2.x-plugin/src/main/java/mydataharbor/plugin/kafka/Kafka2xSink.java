package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.sink.KafkaSinkConfig;
import mydataharbor.sink.kafka.KafkaSink;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka2xSink extends KafkaSink {
  public Kafka2xSink(KafkaSinkConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }

  @Override
  public String name() {
    return super.name()+"2.x";
  }
}
