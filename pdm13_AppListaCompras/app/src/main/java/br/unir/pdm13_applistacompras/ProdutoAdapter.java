package br.unir.pdm13_applistacompras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.MyViewHolder> {

    private List<Produto> listaCompras;

    public ProdutoAdapter(List<Produto> listaCompras) {
        this.listaCompras = listaCompras;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_item, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Produto p = listaCompras.get(position);

        holder.nome.setText(p.getNome());
        holder.preco.setText( "R$" + String.format("%.2f", p.getPreco()) );
        holder.quantidade.setText("Qtd: " + p.getQuantidade());
    }

    @Override
    public int getItemCount() {
        return listaCompras.size();
    }

    //////////////////////////////////////////////////////////////////////////////

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        TextView preco;
        TextView quantidade;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNomeProdutoMercado);
            preco = itemView.findViewById(R.id.textPrecoProdutoMercado);
            quantidade = itemView.findViewById(R.id.textQuantidadeProdutoMercado);
        }
    }

}
