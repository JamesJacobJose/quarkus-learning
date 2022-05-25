package division;

import java.util.List;

import org.mapstruct.Mapper;

import util.QuarkusMappingConfig;

@Mapper(config = QuarkusMappingConfig.class)
public interface DivisionTransformer {

    Division toResource(DivisionEntity divisionEntity);
    List<Division> map(List<DivisionEntity> divisionEntityList);
    DivisionEntity toEntity(Division division);
    
}
