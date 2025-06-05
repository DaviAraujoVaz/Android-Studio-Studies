package persistency;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.Contato;

public class ContatoDAO implements IContatoDAO {
    private final String TABELA_EMISSORES = "Contato";
    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public ContatoDAO(Context context) {
        DbHelper db = new DbHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Contato contato) {
        ContentValues cv = new ContentValues();
        cv.put("nomeContato", contato.getNomeContato());
        cv.put("telContato", contato.getTelContato());

        try {
            write.insert(DbHelper.TABELA_CONTATO, null, cv);
            Log.i("InfoDB", "Sucesso ao salvar o resgistro");
        } catch (Exception e) {
            Log.i("InfoDB", "Falha ao salvar o registro");
            return false;
        }

        return true;
    }

    @Override
    public boolean excluir(Contato contato) {
        try {
            String[] args = {String.valueOf(contato.getId())};
            write.delete(DbHelper.TABELA_CONTATO, "id=?", args);
            Log.i("InfoDB", "Sucesso ao excluir o resgistro");
        } catch (Exception e) {
            Log.i("InfoDB", "Falha ao excluir o registro");
            return false;
        }

        return true;
    }
    
    @Override
    public boolean atualizar(Contato contato) {
        ContentValues cv = new ContentValues();
        cv.put("nomeContato", contato.getNomeContato());
        cv.put("telContato", contato.getTelContato());

        try {
            String[] args = {String.valueOf(contato.getId())};
            // CORREÇÃO: Usar UPDATE em vez de INSERT
            write.update(DbHelper.TABELA_CONTATO, cv, "id=?", args);
            Log.i("InfoDB", "Sucesso ao atualizar o registro");
        } catch (Exception e) {
            Log.i("InfoDB", "Falha ao atualizar o registro: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<Contato> listar() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM " + DbHelper.TABELA_CONTATO + ";";
        try {
            Cursor cursor = read.rawQuery(sql, null);
            int idxid = cursor.getColumnIndexOrThrow("id");
            int idxNome = cursor.getColumnIndexOrThrow("nomeContato");
            int idxTelefone = cursor.getColumnIndexOrThrow("telContato");

            while (cursor.moveToNext()) {
                Contato contato = new Contato();
                contato.setId(cursor.getInt(idxid));
                contato.setNomeContato(cursor.getString(idxNome));
                contato.setTelContato(cursor.getString(idxTelefone));
                contatos.add(contato);
                Log.i("InfoDB", "Sucesso ao pesquisar o registro");
            }
        } catch (Exception e) {
            Log.i("InfoDB", "Erro ao pesquisar o registro");
        }
        return contatos;
    }
}
