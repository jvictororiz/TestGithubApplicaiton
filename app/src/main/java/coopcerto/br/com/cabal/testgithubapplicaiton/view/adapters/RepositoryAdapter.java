package coopcerto.br.com.cabal.testgithubapplicaiton.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
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
import us.feras.mdv.MarkdownView;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {
    private Context context;
    private OnClickButtons onClickButtons;
    private List<RepositoriesReponse> repositoryEntries;
    private StyleButtons styleButtons;

    public RepositoryAdapter(Context context, List<RepositoriesReponse> repositoryEntries, OnClickButtons onClickButtons) {
        this.context = context;
        this.styleButtons = new StyleButtons(context.getString(R.string.salvar), R.color.blue, R.drawable.shape_line_background);
        this.repositoryEntries = repositoryEntries;
        this.onClickButtons = onClickButtons;
    }

    public RepositoryAdapter(Context context, String titleButtonOne, int colorButtonOne, int drawableButotnOne, List<RepositoriesReponse> repositoryEntries, OnClickButtons onClickButtons) {
        this.context = context;
        styleButtons = new StyleButtons(titleButtonOne, colorButtonOne, drawableButotnOne);
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
        private TextView tvNumber, tvName, tvUrl;
        private MarkdownView markdownView;
        private ImageView imgIcon, imgArrow;
        private ExpandableLayout expandableWeightLayout;
        private LinearLayout llBody;
        private Button btnSave, btnGoRepository;

        public RepositoryViewHolder(View v) {
            super(v);
            tvName = v.findViewById(R.id.tv_name);
            tvUrl = v.findViewById(R.id.tv_url);
            markdownView = v.findViewById(R.id.markdown_view);
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
            btnSave.setText(styleButtons.getTextButtonOne());
            btnSave.setBackgroundResource(styleButtons.getDrawableButtonOne());
            btnSave.setTextColor(context.getResources().getColor(styleButtons.getColorTextButtonOne()));
            if (repositoryEntry.getBody().isEmpty()) {
                markdownView.loadMarkdown(context.getString(R.string.text_empty));
            } else {
                markdownView.loadMarkdown(repositoryEntry.getBody());
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

    public class StyleButtons {
        private String buttonOne;
        private int drawableButtonOne;
        private int colorTextButtonOne;

        public StyleButtons(String buttonOne, int colorTextButtonOne, int drawableButtonOne) {
            this.buttonOne = buttonOne;
            this.colorTextButtonOne = colorTextButtonOne;
            this.drawableButtonOne = drawableButtonOne;
        }

        public String getButtonOne() {
            return buttonOne;
        }

        public int getColorTextButtonOne() {
            return colorTextButtonOne;
        }

        public String getTextButtonOne() {
            return buttonOne;
        }

        public void setButtonOne(String buttonOne) {
            this.buttonOne = buttonOne;
        }

        public int getDrawableButtonOne() {
            return drawableButtonOne;
        }

        public void setDrawableButtonOne(int drawableButtonOne) {
            this.drawableButtonOne = drawableButtonOne;
        }
    }

    public interface OnClickButtons {
        void clickButotnSave(RepositoriesReponse repositoriesReponse);

        void clickButtonGoRepository(String repository);
    }
}
