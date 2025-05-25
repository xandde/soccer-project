// src/components/ListaDeJogadores/index.js

import { useState, useEffect } from "react";
import axios from "axios";
import './style.css';

function ListaDeJogadores() {
    const [jogadores, setJogadores] = useState([]);

    useEffect(() => {
        const carregarJogadores = async () => {
            try {
                const response = await axios.get('');
                setJogadores(response.data);
            } catch (error) {
                alert('Erro ao buscar jogadores: ', error);
                setJogadores([]);
            }
        };
        carregarJogadores();
    }, []);

    return (
        <ul id="listaJogadores" className="lista-jogadores">
            {jogadores.length === 0 ? (
                <li>Nenhum jogador encontrado.</li>
            ) : (
                jogadores.map(jogador => (
                    <li key={jogador.id}>
                        <strong>Nome: </strong> {jogador.nome}<br />
                        <strong>Sexo: </strong> {jogador.sexo}<br />
                        <strong>Idade: </strong> {jogador.idade}<br />
                        <strong>Altura: </strong> {jogador.altura}<br />
                        <strong>Clube: </strong> {jogador.clube}<br />
                        <strong>Numero: </strong> {jogador.numero}<br />
                        <strong>Posicao: </strong> {jogador.posicao}
                    </li>
                ))
            )}
        </ul>
    );
}

export default ListaDeJogadores;
