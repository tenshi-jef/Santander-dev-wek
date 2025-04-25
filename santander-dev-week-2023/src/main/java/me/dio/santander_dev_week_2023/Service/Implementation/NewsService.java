package me.dio.santander_dev_week_2023.Service.Implementation;

import me.dio.santander_dev_week_2023.DTO.Read.NewsResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.NewsRequestDTO;
import me.dio.santander_dev_week_2023.Mapper.INewsMapper;
import me.dio.santander_dev_week_2023.Repository.INewsRepository;
import me.dio.santander_dev_week_2023.Service.Interfaces.INewsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class NewsService implements INewsService {

    private final INewsRepository repository;
    private final INewsMapper mapper;

    public NewsService(INewsRepository repository, INewsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ArrayList<NewsResponseDTO> getNews() {
        var list = repository.findTop3ByOrderByDataPublicacaoDesc()
                .stream().map(mapper::toDto)
                .collect(Collectors.toCollection(ArrayList::new));
        return list;
    }

    @Override
    public NewsResponseDTO getNew(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public Long create(NewsRequestDTO newNews) {
        var entity = mapper.toEntity(newNews);
        entity.setDataPublicacao(LocalDateTime.now());
        return repository.save(entity).getId();
    }

    @Override
    public Long update(Long id) {
        var newsOpt = repository.findById(id);

        if (newsOpt.isEmpty()) return 0L;

        var news = newsOpt.get();
        // Atualização simples (poderia ser refinada com um DTO também)
        news.setTitulo("Título atualizado");
        news.setConteudo("Conteúdo atualizado");
        repository.save(news);
        return news.getId();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
