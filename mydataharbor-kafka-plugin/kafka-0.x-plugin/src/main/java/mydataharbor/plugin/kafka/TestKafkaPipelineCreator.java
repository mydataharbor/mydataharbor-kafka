package mydataharbor.plugin.kafka;

import lombok.Data;
import mydataharbor.IDataConverter;
import mydataharbor.IDataPipeline;
import mydataharbor.IDataPipelineCreator;
import mydataharbor.IProtocolData;
import mydataharbor.classutil.classresolver.MyDataHarborMarker;
import mydataharbor.exception.ResetException;
import mydataharbor.kafka.common.sink.KafkaSinkConfig;
import mydataharbor.kafka.common.sink.KafkaSinkReq;
import mydataharbor.kafka.common.source.KafkaDataSourceConfig;
import mydataharbor.kafka.common.source.KafkaProtocalData;
import mydataharbor.pipeline.CommonDataPipeline;
import mydataharbor.plugin.base.util.JsonUtil;
import mydataharbor.setting.BaseSettingContext;
import mydataharbor.source.kafka.protocal.KafkaProtocalConvertor;

import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;

/**
 * @author xulang
 * @date 2023/2/3
 */
@Extension
public class TestKafkaPipelineCreator implements IDataPipelineCreator<TestKafkaPipelineCreator.TestPipelineCreatorConfig, BaseSettingContext> , ExtensionPoint {

    @Override
    public String type() {
        return "kafka数据源和输入源测试管道";
    }

    @Override
    public IDataPipeline createPipeline(TestPipelineCreatorConfig testPipelineCreatorConfig, BaseSettingContext baseSettingContext) throws Exception {
        CommonDataPipeline commonDataPipeline = CommonDataPipeline.builder()
                .dataSource(new Kafka0xDataSource(testPipelineCreatorConfig.dataSourceConfig))
                .protocolDataConverter(new KafkaProtocalConvertor())
                .dataConverter(new IDataConverter<KafkaProtocalData, KafkaSinkReq, BaseSettingContext>() {
                    @Override
                    public KafkaSinkReq convert(KafkaProtocalData protocalData, BaseSettingContext baseSettingContext) throws ResetException {
                        KafkaSinkReq kafkaSinkReq = new KafkaSinkReq();
                        kafkaSinkReq.setKey(protocalData.getKey());
                        kafkaSinkReq.setValue(protocalData.getValue());
                        return kafkaSinkReq;
                    }
                })
                .sink(new Kafka0xSink(testPipelineCreatorConfig.sinkConfig))
                .settingContext(baseSettingContext)
                .build();
        return commonDataPipeline;
    }

    @Override
    public <T> T parseJson(String s, Class<T> aClass) {
        return JsonUtil.jsonToObject(s, aClass);
    }

    @Data
    public static class TestPipelineCreatorConfig {
        @MyDataHarborMarker(title = "kafka数据源配置")
        private KafkaDataSourceConfig dataSourceConfig;
        @MyDataHarborMarker(title = "kafka目标源配置")
        private KafkaSinkConfig sinkConfig;
    }
}
