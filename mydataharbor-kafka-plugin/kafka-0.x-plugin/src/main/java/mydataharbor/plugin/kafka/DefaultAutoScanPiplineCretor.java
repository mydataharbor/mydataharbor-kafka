package mydataharbor.plugin.kafka;

import mydataharbor.IDataPipeline;
import mydataharbor.plugin.base.creator.AbstractAutoScanPipelineCreator;
import mydataharbor.setting.BaseSettingContext;

import java.util.Map;

import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;

/**
 * Created by xulang on 2021/8/17.
 */
@Extension
public class DefaultAutoScanPiplineCretor extends AbstractAutoScanPipelineCreator<Map<String, Object>, BaseSettingContext> implements ExtensionPoint {
  @Override
  public String scanPackage() {
    return "mydataharbor.plugin.kafka";
  }

  @Override
  public String type() {
    return "kafka0.x组件扫描器";
  }

  @Override
  public IDataPipeline createPipeline(Map<String, Object> config, BaseSettingContext settingContext) throws Exception {
    throw new RuntimeException("此创建器无法创建pipline");
  }

  @Override
  public boolean canCreatePipeline() {
    return false;
  }
}