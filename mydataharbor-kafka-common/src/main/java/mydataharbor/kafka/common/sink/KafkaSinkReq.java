package mydataharbor.kafka.common.sink;

import lombok.Data;

import java.util.Map;

/**
 * Created by xulang on 2021/8/20.
 */
@Data
public class KafkaSinkReq {
  /**
   * topic，可选，如果不指定则使用sink配置中的topic
   */
  private String topic;
  /**
   * 可选，用于数据partition路由
   */
  private String key;

  private String value;

  private Map<String, String> header;
}
