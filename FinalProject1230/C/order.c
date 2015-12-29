#include "order.h"





int make_socket_non_blocking ( int sockfd ){
    int flags, s;   
    flags = fcntl (sockfd, F_GETFL, 0);     
    if (flags == -1){
        perror ("fcntl");
        return -1;
    }// if flag == -1
                           
    flags |= O_NONBLOCK;
    s = fcntl (sockfd, F_SETFL, flags);
     
    if (s == -1){
        perror ("fcntl");
        return -1;
    }//if s==-1                                                    
    return 0;
}// int make_socket_non_blocking


void json_parse(json_object * jobj){
	int price;
	int id;
	int which;
	int set;
	int set_coll;
	json_object_object_foreach(jobj, key, val) {
		if (strcmp(key,"price") == 0){
			price = atoi(json_object_get_string(val));		
		}//if strcmp(key,price)		
		else if (strcmp(key,"set") == 0){
			set = atoi(json_object_get_string(val));
		}//else if strcmp(key,set)
		else if (strcmp(key,"set_coll") == 0){
			set_coll = atoi(json_object_get_string(val));
		}//else if strcmp(key,set_coll)
		else if (strcmp(key,"id") == 0){
			id = atoi(json_object_get_string(val));
		}//else if strcmp(key,id)
		else if (strcmp(key,"which") == 0){
			which = atoi(json_object_get_string(val));			
		}//else if srcmp(key,which)		
	}//json_object_object_foreach	
	show(id,set,set_coll,price,which);
}//json_parse

void show(int id , int set , int set_coll , int price ,int which){
	char* set_food[9] = {"�j���J","�l�����L��","�O�N���L��","���J����(6��)","���J����(9��)","������(2��)","������","������"};
	char* set_coll_food[5] = {"�g��t�\","�M�n�t�\","�Ŭ��t�\","�l�ܰt�\"};
	char* set_price[9] = {"99��","99��","99��","79��","89��","109��","89��","89��"};
	char* set_coll_price[5] = {"30��","40��","50��","60��"};	
		switch(which){
			case 0 :			
				printf("����Ӧ� 0%d ���q��G���I (%s : %s)\n",id,set_food[set],set_price[set]);
				printf("�@�G%d��\n",price);
			break;

			case 1:
				printf("����Ӧ� 0%d ���q��G�M�\ (%s : %s) + (%s : %s)\n",id,set_food[set],set_price[set],set_coll_food[set_coll],set_coll_price[set_coll]);
				printf("�@�G%d��\n",price);
			break;

			default:
			break;
		}//switch which
}//show
