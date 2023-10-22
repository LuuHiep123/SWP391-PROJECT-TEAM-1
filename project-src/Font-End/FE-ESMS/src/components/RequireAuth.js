import { useLocation, Navigate, Outlet } from "react-router-dom";
import useAuth from "../hooks/useAuth";

// Role-Based Version
// const RequireAuth = ({ allowedRoles }) => {
//     const { auth } = useAuth();
//     const location = useLocation();

//     return (
//         auth?.roles?.find(role => allowedRoles?.includes(role))
//             ? <Outlet />
//             : auth?.user
//                 ? <Navigate to="/unauthorized" state={{ from: location }} replace />
//                 : <Navigate to="/login" state={{ from: location }} replace />
//     );
// }
// this help us protect the routes
const RequireAuth = () => {
    const { auth } = useAuth();
    const location = useLocation();

    return ( 
        
        auth?.user // auth like Boolean to check object(user)
            ? <Outlet /> // Outlet: any child component of require auth , so this require  
            //auth component  can protect all the child
                : <Navigate to="/login" state={{ from: location }} replace /> 
                // This is will send user not login to login page .
                
    );
}

export default RequireAuth;