import { useContext } from "react";
import AuthContext from "../context/AuthProvider";

const useAuth = () => { // use this like golbal Auth
    return useContext(AuthContext);
}

export default useAuth;