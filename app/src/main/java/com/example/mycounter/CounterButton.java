package com.example.mycounter;

        import android.app.Activity;
        import android.app.Fragment;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;

public class CounterButton extends Fragment {

    public Button incrementBtn;
    public int counter;
    Communicator comm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.counter_button_frag,container,false);
        incrementBtn = (Button) v.findViewById(R.id.button);
        Log.i("TESTING","Fragment onCreate");

        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                comm.respond("" + Integer.toString(counter));
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        setRetainInstance(true);
        if (b == null) {
            counter = 0;
        }
        comm = (Communicator) getActivity();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }
}
