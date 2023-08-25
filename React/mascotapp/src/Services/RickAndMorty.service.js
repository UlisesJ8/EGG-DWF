import { API_RM } from "../constants/Api.cotants";

class RickAndMortyService{

    async getAllCharacters(){
        const response = await fetch(API_RM.CHARACTERS())
        //Interceptor
        return response.json();
    }

    async getAllCharactersById(id){
        const response = await fetch(API_RM.CHARACTERS_BY_ID(id))
        //Interceptor
        return response.json();
    }


}

export default new RickAndMortyService();