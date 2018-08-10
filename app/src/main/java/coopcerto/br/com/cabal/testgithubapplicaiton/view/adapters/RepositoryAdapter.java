package coopcerto.br.com.cabal.testgithubapplicaiton.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.chuross.library.ExpandableLayout;
import com.squareup.picasso.Picasso;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.util.CircleTransform;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {
    private Context context;
    private OnClickButtons onClickButtons;
    private List<RepositoriesReponse> repositoryEntries;

    public RepositoryAdapter(Context context, List<RepositoriesReponse> repositoryEntries, OnClickButtons onClickButtons) {
        this.context = context;
        this.repositoryEntries = repositoryEntries;
        this.onClickButtons = onClickButtons;
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
        private boolean isExpand;
        private TextView tvNumber, tvName, tvUrl, tvInformation;
        private ImageView imgIcon, imgArrow;
        private ExpandableLayout expandableWeightLayout;
        private LinearLayout llBody;
        private Button btnSave, btnGoRepository;

        public RepositoryViewHolder(View v) {
            super(v);
            tvName = v.findViewById(R.id.tv_name);
            tvUrl = v.findViewById(R.id.tv_url);
            tvInformation = v.findViewById(R.id.tv_information);
            imgIcon = v.findViewById(R.id.img_icon);
            imgArrow = v.findViewById(R.id.img_arrow);
            tvNumber = v.findViewById(R.id.tv_number);
            btnGoRepository = v.findViewById(R.id.btn_go_repository);
            btnSave = v.findViewById(R.id.btn_sae);
            expandableWeightLayout = v.findViewById(R.id.expandable);
            llBody = v.findViewById(R.id.ll_body);
        }

        public void createViews(final RepositoriesReponse repositoryEntry) {
            isExpand = true;
            String textNumber = "Número - " + repositoryEntry.getNumber();
            tvNumber.setText(textNumber);
            tvName.setText(repositoryEntry.getTitle());
            tvUrl.setText(repositoryEntry.getHtmlUrl());

            if (repositoryEntry.getBody().isEmpty()) {
                tvInformation.setText(R.string.text_empty);
            } else {
                tvInformation.setText(repositoryEntry.getBody());
            }
            Picasso.with(context)
                    .load(repositoryEntry.getUser().getAvatarUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .transform(new CircleTransform())
                    .into(imgIcon);

            llBody.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isExpand = !isExpand;
                    int rotation = isExpand ? 0 : 90;
                    imgArrow.animate().rotation(rotation).setDuration(600);
                    expandableWeightLayout.toggle();
                }
            });

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickButtons.clickButotnSave(repositoryEntry);
                }
            });

            btnGoRepository.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickButtons.clickButtonGoRepository(repositoryEntry.getHtmlUrl());
                }
            });

        }
    }

    public interface OnClickButtons {
        void clickButotnSave(RepositoriesReponse repositoriesReponse);

        void clickButtonGoRepository(String repository);
    }
}
