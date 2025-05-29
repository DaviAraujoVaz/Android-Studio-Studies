package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contatosan.R;

import java.util.List;

import model.Contato;

public class AdapterContato extends RecyclerView.Adapter<AdapterContato.MyViewHolder> {
    private List<Contato> listaContatos;
    private Context context;

    public AdapterContato(List<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_contato, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contato contato = listaContatos.get(position);
        holder.nomeContato.setText(contato.getNomeContato());
        holder.telefoneContato.setText(contato.getTelContato());

    }

    @Override
    public int getItemCount() {
        return listaContatos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nomeContato, telefoneContato;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeContato = itemView.findViewById(R.id.lblNomeContato);
            telefoneContato = itemView.findViewById(R.id.lblTelefoneContato);


        }
    }
}
