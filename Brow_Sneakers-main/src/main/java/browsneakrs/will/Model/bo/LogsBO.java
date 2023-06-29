package browsneakrs.will.Model.bo;

import browsneakrs.will.Model.dao.impl.LogsDAO;
import browsneakrs.will.Model.entity.Logs;
import browsneakrs.will.Model.dto.LogsDTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class LogsBO {
    @Inject
    LogsDAO logDAO;

    public Boolean save(LogsDTO dto) {
        logDAO.insert(new Logs(dto));
        return true;
    }

    public List<LogsDTO> getAllLog(){
        List<Logs> logList = logDAO.getAll();
        List<LogsDTO> logDTOList = logList.stream().map((log) -> {
            LogsDTO logDTO = new LogsDTO();
            logDTO.setUsuario(log.getUsuario());
            logDTO.setUrl(log.getUrl());
            logDTO.setMetodo(log.getMetodo());
            logDTO.setData_atual(log.getData_atual());
            return logDTO;
        }).collect(Collectors.toList());
        return logDTOList;
    }
}
