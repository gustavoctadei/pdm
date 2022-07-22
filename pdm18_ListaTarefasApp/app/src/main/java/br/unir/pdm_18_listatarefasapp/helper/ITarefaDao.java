package br.unir.pdm_18_listatarefasapp.helper;

import java.util.List;

import br.unir.pdm_18_listatarefasapp.model.Tarefa;

public interface ITarefaDao {
    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();
}
