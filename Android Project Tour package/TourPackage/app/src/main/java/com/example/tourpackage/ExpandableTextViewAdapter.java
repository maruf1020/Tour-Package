package com.example.tourpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableTextViewAdapter extends BaseExpandableListAdapter {

    Context context;

    String[]faqs={
            "Why we use this app?",
            "Is it possible to find tour package easily?",
            "how to payment",
            "Why we use this app?",
            "Is it possible to find tour package easily?",
            "how to payment"
    };

    String[][]answer={
            {
                "With the mobile application the user will be able to book a tour package. The users will also be able to search for a specific tour package with name or find it from the category menu.The web portal will have two parts, one for the administrator and another one is for the tourist. The tourist will be able to book a tour package from here also. The website and the app will be supported the AI feature. As a result, the web portal will be accessible from any device as it won’t have any hardware constrain. The admins of the portal will be able to add new tour package with details, receive booking and also get analytical data on tour package."
            },
            {
                "This is very light app with a lot of function. you can find a lot of thing here. the most important part is our chat bor. you can ask any question related to our apps"
            },
            {
                 "you can pay in may ways. we have internation mayment option, bank payment option, we also allowed bikash rocket etc... And you also pay as cash on delivery"
            },
            {
                    "With the mobile application the user will be able to book a tour package. The users will also be able to search for a specific tour package with name or find it from the category menu.The web portal will have two parts, one for the administrator and another one is for the tourist. The tourist will be able to book a tour package from here also. The website and the app will be supported the AI feature. As a result, the web portal will be accessible from any device as it won’t have any hardware constrain. The admins of the portal will be able to add new tour package with details, receive booking and also get analytical data on tour package."
            },
            {
                    "This is very light app with a lot of function. you can find a lot of thing here. the most important part is our chat bor. you can ask any question related to our apps"
            },
            {
                    "you can pay in may ways. we have internation mayment option, bank payment option, we also allowed bikash rocket etc... And you also pay as cash on delivery"
            }
    };


    public ExpandableTextViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return faqs.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return answer[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return faqs[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return answer[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String questionFaq = (String)getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.faqs_title,null);
        }
        TextView questionFaq2=convertView.findViewById(R.id.faqsTitleView);
        questionFaq2.setTypeface(null, Typeface.BOLD);
        questionFaq2.setText(questionFaq);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String answerFaq = (String)getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.faq_answer,null);
        }
        TextView answerFaq2=convertView.findViewById(R.id.descriptionFaqView);
        answerFaq2.setText(answerFaq);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
