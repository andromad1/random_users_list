package ua.andromad.testassignmentaxon.adapters;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ua.andromad.testassignmentaxon.R;
import ua.andromad.testassignmentaxon.activities.RandomUserFragment.OnListFragmentInteractionListener;
import ua.andromad.testassignmentaxon.response.User;
import ua.andromad.testassignmentaxon.utils.UtilNetwork;

public class RandomUserRecyclerViewAdapter extends RecyclerView.Adapter<RandomUserRecyclerViewAdapter.ViewHolder> {

    private final List<User> mUsers = new ArrayList<>();
    private final OnListFragmentInteractionListener mListener;
    private int pageNum = 2;

    public RandomUserRecyclerViewAdapter(OnListFragmentInteractionListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_random_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mUsers.size()>0 && position==mUsers.size()-1) {
            UtilNetwork.loadUsers(this, holder.mView.getContext(), pageNum);
            pageNum++;
        }

        holder.mItem = mUsers.get(position);
        holder.mUserFullName.setText(mUsers.get(position).getUserName().getFirst()+" "+
                mUsers.get(position).getUserName().getLast());
        holder.mUserEmail.setText(mUsers.get(position).getEmail());
        Picasso.get().load(mUsers.get(position).getPicture().getMedium()).into(holder.userImageView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setItems(Collection<User> users) {
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mUserFullName;
        public final TextView mUserEmail;
        public final ImageView userImageView;
        public User mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mUserFullName = (TextView) view.findViewById(R.id.user_name);
            mUserEmail = (TextView) view.findViewById(R.id.user_email);
            userImageView = view.findViewById(R.id.user_image_small);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mUserFullName.getText() + "'";
        }
    }
}
