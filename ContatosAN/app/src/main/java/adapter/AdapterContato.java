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
    private OnItemClickListener onItemClickListener;

    public AdapterContato(List<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
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

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(contato, position);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemLongClick(contato, position);
            }
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return listaContatos.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Contato contato, int position);

        void onItemLongClick(Contato contato, int position);
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
