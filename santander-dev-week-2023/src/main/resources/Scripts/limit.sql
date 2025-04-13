INSERT INTO tb_limite (
    cartao_id,
    saldo_conta_corrente,
    limite_total,
    credito_especial_disponivel,
    credito_especial_total,
    credito_especial_habilitado
) VALUES
(1, 1000.00, 1500.00, 500.00, 500.00, TRUE),
(2, 800.00, 800.00, 0.00, 500.00, FALSE);
