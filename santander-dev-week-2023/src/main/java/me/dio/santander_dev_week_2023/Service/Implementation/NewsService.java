package me.dio.santander_dev_week_2023.Service.Implementation;

import me.dio.santander_dev_week_2023.DTO.Read.NewsResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.NewsRequestDTO;
import me.dio.santander_dev_week_2023.Service.Interfaces.INewsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsService implements INewsService {

    public ArrayList<NewsResponseDTO> getNews() {
        return null;
    }

    public NewsResponseDTO getNew(Long id) {
        return null;
    }

    public Long create(NewsRequestDTO newNews) {
        return 0L;
    }

    public Long update(Long id) {
        return 0L;
    }

    public void delete(Long id) {
    }
}
