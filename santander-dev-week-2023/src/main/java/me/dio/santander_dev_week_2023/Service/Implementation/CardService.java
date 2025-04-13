package me.dio.santander_dev_week_2023.Service.Implementation;

import jakarta.transaction.Transactional;
import me.dio.santander_dev_week_2023.Repository.ICardRepository;
import me.dio.santander_dev_week_2023.Response.ApiResponse;
import me.dio.santander_dev_week_2023.Service.Interfaces.ICardService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICardService {

    private ICardRepository cardRepository;

    public CardService(ICardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    public ApiResponse getCard(Long contaId) {
        var response = cardRepository.findByContaId(contaId);

        if (response == null) new ApiResponse(List.of(), null, HttpStatus.NO_CONTENT);

        return new ApiResponse(response, null, HttpStatus.OK);
    }

    // TODO: Gerar cartão junto a criação da conta
    /*@Transactional
    public ApiResponse create(CardResponseDTO newCard) {
        var exists = cardRepository.existsByNumero();
    }
     */

    @Transactional
    public ApiResponse delete(Long id) {
        if (!cardRepository.existsById(id))
        {
            return new ApiResponse(null, "Usuário não encontrado!", HttpStatus.NOT_FOUND);
        }

        cardRepository.deleteById(id);

        return new ApiResponse(id, null, HttpStatus.OK);
    }
}
