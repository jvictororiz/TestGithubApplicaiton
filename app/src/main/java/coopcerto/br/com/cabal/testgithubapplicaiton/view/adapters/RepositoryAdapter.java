package coopcerto.br.com.cabal.testgithubapplicaiton.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.model.RepositoryEntry;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {
    private Context context;
    private List<RepositoryEntry> repositoryEntries;

    public RepositoryAdapter(Context context, List<RepositoryEntry> repositoryEntries) {
        this.context = context;
        this.repositoryEntries = repositoryEntries;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_repository, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        holder.createViews(repositoryEntries.get(position));

    }

    @Override
    public int getItemCount() {
        return repositoryEntries.size();
    }

    public class RepositoryViewHolder extends RecyclerView.ViewHolder {

        public RepositoryViewHolder(View itemView) {
            super(itemView);
        }

        public void createViews(RepositoryEntry repositoryEntry) {

        }
    }
}
