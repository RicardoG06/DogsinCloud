const User = require('../models/user');
const Rol_ad_us = require('../models/rol_ad_usu')
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const keys = require('../config/keys');

module.exports = {
    async getAll(req,res,next){
        try{
            const data = await User.getAll();
            console.log(`Usuarios: ${data}`);
            return res.status(201).json(data);
        }
        catch(error){
            console.log(`Error: ${error}`);
            return res.status(501).json({
                success: false,
                message: 'Error al obtener los usuarios'
            });
        }  

    },

    async register(req,res,next){
        try {
            const user = req.body;
            const data = await User.create(user);

            await Rol_ad_us.create(data.id, 1);

            const token = jwt.sign({ id: data.id, email: user.email }, keys.secretOrKey, {
                // expiresIn:
            })

            const myData = {
                id: data.id,
                name: user.name,
                lastname: user.lastname,
                email: user.email,
                dni: user.dni,
                edad: user.edad,
                phone: user.phone,
                image: user.image,
                session_token: `JWT ${token}`
            };

            return res.status(201).json({
                success: true,
                message: 'El registro se realizo correctamente',
                data:myData
            });
        } catch (error) {
            console.log(`Error: ${error}`);
            return res.status(501).json({
                success: false,
                message: 'Hubo un error con el registro del usuario',
                error: error
            });
        }
    },

    async login(req,res,next){
        try {
            const email = req.body.email;
            const password = req.body.password;

            const myUser = await User.findByEmail(email);

            if(!myUser){
                return res.status(401).json({
                    success: false,
                    message: 'El email no fue encontrado'
                })
            }

            const isPasswordValid = await bcrypt.compare(password, myUser.password)

            if(isPasswordValid){
                const token = jwt.sign({ id: myUser.id, email: myUser.email }, keys.secretOrKey, {
                    // expiresIn:
                })

                const data = {
                    id: myUser.id,
                    name: myUser.name,
                    lastname: myUser.lastname,
                    email: myUser.email,
                    dni: myUser.dni,
                    edad: myUser.edad,
                    phone: myUser.phone,
                    image: myUser.image,
                    session_token: `JWT ${token}`,
                    roles: myUser.roles
                };

                console.log(`USUARIO ENVIADO ${data}`);

                return res.status(201).json({
                    success: true,
                    message: 'El usuario a sido autenticado',
                    data: data
                })
            }
            else{
                return res.status(201).json({
                    success: false,
                    message: 'La contrase??a es incorrecta',
                    data: data
                })
            }

        } catch (error) {
            console.log(`Error: ${error}`);
            return res.status(501).json({
                success: false,
                message: 'Hubo un error con el login del usuario',
                error: error
            });
        }
    }




};