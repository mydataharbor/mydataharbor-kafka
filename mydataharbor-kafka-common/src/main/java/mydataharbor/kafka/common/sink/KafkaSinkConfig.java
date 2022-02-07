package mydataharbor.kafka.common.sink;

import lombok.Data;
import mydataharbor.classutil.classresolver.MyDataHarborMarker;

import java.util.Properties;

/**
 * kafka配置
 *
 * @auth xulang
 * @Date 2021/5/7
 **/
@MyDataHarborMarker(title = "普通kafka服务连接配置")
@Data
public class KafkaSinkConfig {

  public KafkaSinkConfig() {
    super();
  }

  @MyDataHarborMarker(title = "要写入的topic")
  private String topic;

  @MyDataHarborMarker(title = "kafka服务器地址", des = "多个地址用逗号分隔")
  private String bootstrapServers;

  @MyDataHarborMarker(title = "kafka配置", require = false)
  private Properties kafkaConfig;

  @MyDataHarborMarker(title = "是否同步发送")
  private boolean sync = true;
}
