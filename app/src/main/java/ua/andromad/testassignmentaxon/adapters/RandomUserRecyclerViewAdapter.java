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
import ua.andromad.testassignmentaxon.activities.ListFragmentInteractionListener;
import ua.andromad.testassignmentaxon.response.User;

public class RandomUserRecyclerViewAdapter extends RecyclerView.Adapter<RandomUserRecyclerViewAdapter.ViewHolder> {

    private final List<User> mUsers = new ArrayList<>();
    private final ListFragmentInteractionListener mListener;

    public RandomUserRecyclerViewAdapter(ListFragmentInteractionListener listener) {
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
            mListener.onEndOfListReached();
        }

        holder.mItem = mUsers.get(position);
        holder.mUserFullName.setText(mUsers.get(position).getUserName().getFirst()+" "+
                mUsers.get(position).getUserName().getLast());
        holder.mUserEmail.setText(mUsers.get(position).getEmail());
        Picasso.get().load(mUsers.get(position).getPicture().getMedium()).into(holder.userImageView);

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onUserSelected(holder.mItem);
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
