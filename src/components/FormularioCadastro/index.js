import { useState } from "react";
import './style.css';
import { useNavigate } from "react-router-dom";
import useMensagem from '../../hooks/useMensagem';
import MensagemFeedback from '../MensagemFeedback';
import logo from '../../assets/images/logo.png';
import axios from 'axios';

function FormularioCadastro() {
    const [nome, setNome] = useState('');
    const [sexo, setSexo] = useState('');
    const [idade, setIdade] = useState('');
    const [altura, setAltura] = useState('');
    const [clube, setClube] = useState('');
    const [numero, setNumero] = useState('');
    const [posicao, setPosicao] = useState('');
    const navigate = useNavigate();
    const { exibirMensagem , mensagem, tipoMensagem, visivel, fecharMensagem } = useMensagem();

    const cadastrarJogador = async () => {
        try {
            const response = await axios.post('', {
                nome,
                sexo,
                idade,
                altura,
                clube,
                numero,
                posicao,
                
            });
            exibirMensagem(response.data.mensagem || 'Jogador cadastrado com sucesso!', 'sucesso');
            setNome('');
            setSexo('');
            setIdade('');
            setAltura('');
            setClube('');
            setNumero('');
            setPosicao('');
        } catch (error) {
            let erroMsg = 'Erro ao conectar ao servidor.';
            if (error.response && error.response.data) {
                erroMsg = error.response.data.mensagem;
                if (error.response.data.erros) {
                    erroMsg += ' ' + Object.values(error.response.data.erros).join(', ');
                }
            }
            exibirMensagem(erroMsg, 'erro');
        }
    };

    return (
        <div className="container">
            <img src={logo} alt="Logo da Empresa" />
            <h2>CADASTRO DE JOGADORES</h2>
            <form onSubmit={(e) => { e.preventDefault(); cadastrarJogador(); }}>
                <input 
                    type="text"
                    id="nome"
                    placeholder="Nome do Jogador"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                    required
                />
                <input 
                    type="text"
                    id="sexo"
                    placeholder="Gênero do Jogador"
                    value={sexo}
                    onChange={(e) => setSexo(e.target.value)}
                    required
                />
                <input 
                    type="number"
                    id="idade"
                    placeholder="Idade do Jogador"
                    value={idade}
                    onChange={(e) => setIdade(e.target.value)}
                    required
                />
                <input 
                    type="number"
                    id="altura"
                    placeholder="Altura do Jogador"
                    value={altura}
                    onChange={(e) => setAltura(e.target.value)}
                    required
                />
                <input 
                    type="number"
                    id="numero"
                    placeholder="Número da Camisa"
                    value={numero}
                    onChange={(e) => setNumero(e.target.value)}
                    required
                />
                <input 
                    type="text"
                    id="clube"
                    placeholder="Nome do Clube"
                    value={clube}
                    onChange={(e) => setClube(e.target.value)}
                    required
                />
                <input 
                    type="text"
                    id="posicao"
                    placeholder="Posição"
                    value={posicao}
                    onChange={(e) => setPosicao(e.target.value)}
                    required
                />
                <button type="submit">CADASTRAR AGORA</button>
            </form>

            <button onClick={() => navigate('/jogadores')} className="link-jogadores">
                VER LISTA DE JOGADORES
            </button>

            <MensagemFeedback
                mensagem={mensagem}
                tipo={tipoMensagem}
                visivel={visivel}
                onclose={fecharMensagem}
            />
        </div>
    );
}

export default FormularioCadastro;
